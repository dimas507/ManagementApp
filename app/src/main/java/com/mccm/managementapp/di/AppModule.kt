package com.mccm.managementapp.di

import com.google.firebase.auth.FirebaseAuth
import com.mccm.managementapp.data.repository.AuthRepositoryImpl
import com.mccm.managementapp.domain.repository.AuthRepository
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.auth.GetCurrentUser
import com.mccm.managementapp.domain.use_cases.auth.Login
import com.mccm.managementapp.domain.use_cases.auth.Logout
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Dependency injection
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providesAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository)
    )
}