package com.mccm.managementapp.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.mccm.managementapp.core.Constants.POST
import com.mccm.managementapp.domain.model.Post
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.repository.AnnotationRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class PostsRespositoryImpl @Inject constructor(
    @Named(POST) private val postsRef: CollectionReference,
    @Named(POST) private val storagePostsRsef: StorageReference
) : AnnotationRepository {

    override suspend fun create(post: Post, file: File): Response<Boolean> {
        return try {
            // IMAGE
            val fromFile = Uri.fromFile(file)
            val ref = storagePostsRsef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            // DATA
            post.image = url.toString()
            postsRef.add(post).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getPost(): Flow<Response<List<Post>>> = callbackFlow {
        val snapshotListener = postsRef.addSnapshotListener{
            snapshot, e ->
            val postResponse = if (snapshot != null){
                val posts = snapshot.toObjects(Post::class.java)
                Response.Success(posts)
            }
            else    {
                Response.Failure(e)
            }
            trySend(postResponse)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }
}