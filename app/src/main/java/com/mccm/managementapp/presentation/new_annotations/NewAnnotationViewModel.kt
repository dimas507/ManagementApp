package com.mccm.managementapp.presentation.new_annotations

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mccm.managementapp.R
import com.mccm.managementapp.domain.model.Post
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.posts.PostsUseCases
import com.mccm.managementapp.presentation.utils.ComposeFileProvider
import com.mccm.managementapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

@HiltViewModel
class NewAnnotationViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val postsUseCases: PostsUseCases,
    private val authUseCases: AuthUseCases
):ViewModel() {

    var state by mutableStateOf(NewAnnotationState())
    val currentUser = authUseCases.getCurrentUser()
    val radioOptions = listOf(
        CategoryRadioButton("Behavior", R.drawable.comportamiento),
        CategoryRadioButton("Goals", R.drawable.metas),
        CategoryRadioButton("Feedback", R.drawable.comentario),
        CategoryRadioButton("Special Needs", R.drawable.necesidades_especiales),
        CategoryRadioButton("Others", R.drawable.participation)
    )
    var createPostResponse by mutableStateOf<Response<Boolean>?>(null)
    private set

    //File
    var file: File? = null

    val resultingActivityHandler = ResultingActivityHandler()

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onCategoryInput(category: String){
        state = state.copy(category = category)
    }

    fun onDescriptionInput(description: String){
        state = state.copy(description = description)
    }

    fun onImageInput(image: String){
        state = state.copy(image = image)
    }

    fun takePhoto()= viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if(result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context,result))
            file = File(state.image)
        }
    }
    fun pickImage()= viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if(result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state =state.copy(image = result.toString() )
        }
    }
    fun createPost(post: Post) = viewModelScope.launch {
        createPostResponse = Response.Loading
        val defaultImage = BitmapFactory.decodeResource(context.resources, R.drawable.add_image)
        val defaultFile = File(context.cacheDir, "default_image.jpg")
        val outputStream = FileOutputStream(defaultFile)
        defaultImage.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.close()
        val fileToUse = file ?: defaultFile
        val result = postsUseCases.create(post, fileToUse)
        createPostResponse = result
        if (result is Response.Success) {
            clearForm()
        }
    }

    fun onNewAnnotation(){
        val post = Post(
            name = state.name,
            description = state.description,
            category =  state.category,
            image = state.image,
            idUser = currentUser?.uid ?: ""
        )
        createPost(post)
    }

    fun clearForm(){
        state = state.copy(
            name = "",
            description = "",
            category =  "",
            image = ""
        )
    }

}

data class CategoryRadioButton(
    var category: String,
    var image: Int
)