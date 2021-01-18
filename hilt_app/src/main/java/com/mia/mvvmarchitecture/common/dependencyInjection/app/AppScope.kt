package com.mia.mvvmarchitecture.common.dependencyInjection.app

import dagger.hilt.migration.AliasOf
import javax.inject.Scope
import javax.inject.Singleton

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@Scope
@AliasOf(Singleton::class)
annotation class AppScope {
}