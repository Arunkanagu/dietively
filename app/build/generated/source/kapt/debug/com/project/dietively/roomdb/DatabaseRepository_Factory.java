package com.project.dietively.roomdb;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DatabaseRepository_Factory implements Factory<DatabaseRepository> {
  private final Provider<DatabaseDao> databaseDaoProvider;

  public DatabaseRepository_Factory(Provider<DatabaseDao> databaseDaoProvider) {
    this.databaseDaoProvider = databaseDaoProvider;
  }

  @Override
  public DatabaseRepository get() {
    return newInstance(databaseDaoProvider.get());
  }

  public static DatabaseRepository_Factory create(Provider<DatabaseDao> databaseDaoProvider) {
    return new DatabaseRepository_Factory(databaseDaoProvider);
  }

  public static DatabaseRepository newInstance(DatabaseDao databaseDao) {
    return new DatabaseRepository(databaseDao);
  }
}
