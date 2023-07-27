package com.mccm.managementapp.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.mccm.managementapp.core.Constants.POST
import com.mccm.managementapp.core.Constants.USERS
import com.mccm.managementapp.data.repository.AuthRepositoryImpl
import com.mccm.managementapp.data.repository.PostsRespositoryImpl
import com.mccm.managementapp.data.repository.UsersRepositoryImpl
import com.mccm.managementapp.domain.repository.AnnotationRepository
import com.mccm.managementapp.domain.repository.AuthRepository
import com.mccm.managementapp.domain.repository.UsersRepository
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.auth.GetCurrentUser
import com.mccm.managementapp.domain.use_cases.auth.Login
import com.mccm.managementapp.domain.use_cases.auth.Logout
import com.mccm.managementapp.domain.use_cases.auth.Signup
import com.mccm.managementapp.domain.use_cases.posts.CreatePost
import com.mccm.managementapp.domain.use_cases.posts.GetPost
import com.mccm.managementapp.domain.use_cases.posts.PostsUseCases
import com.mccm.managementapp.domain.use_cases.users.Create
import com.mccm.managementapp.domain.use_cases.users.GetUserById
import com.mccm.managementapp.domain.use_cases.users.SaveImage
import com.mccm.managementapp.domain.use_cases.users.Update
import com.mccm.managementapp.domain.use_cases.users.UsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

//Dependency injection
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore():FirebaseFirestore = Firebase.firestore
    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)
    @Provides
    @Named(USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage) :
            StorageReference = storage.reference.child(USERS)
    @Provides
    @Named(POST)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POST)
    @Provides
    @Named(POST)
    fun provideStoragePostRef(storage: FirebaseStorage) :
            StorageReference = storage.reference.child(POST)
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl
    @Provides
    fun providePostsRepository(impl: PostsRespositoryImpl): AnnotationRepository = impl

    @Provides
    fun providesAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )
    @Provides
    fun  provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository)
    )
    @Provides
    fun  providePostsUseCases(repository: AnnotationRepository) = PostsUseCases(
        create = CreatePost(repository),
        getPost = GetPost(repository)
    )
    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()
}