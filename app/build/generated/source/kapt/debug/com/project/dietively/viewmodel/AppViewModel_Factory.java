package com.project.dietively.viewmodel;

import com.project.dietively.roomdb.DatabaseRepository;
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
public final class AppViewModel_Factory implements Factory<AppViewModel> {
  private final Provider<DatabaseRepository> databaseRepositoryProvider;

  public AppViewModel_Factory(Provider<DatabaseRepository> databaseRepositoryProvider) {
    this.databaseRepositoryProvider = databaseRepositoryProvider;
  }

  @Override
  public AppViewModel get() {
    return newInstance(databaseRepositoryProvider.get());
  }

  public static AppViewModel_Factory create(
      Provider<DatabaseRepository> databaseRepositoryProvider) {
    return new AppViewModel_Factory(databaseRepositoryProvider);
  }

  public static AppViewModel newInstance(DatabaseRepository databaseRepository) {
    return new AppViewModel(databaseRepository);
  }
}
