// Generated by Dagger (https://dagger.dev).
package com.zzu.afreecatv.data.datasource.broad;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TestDataSourceImpl_Factory implements Factory<BroadDataSourceImpl> {
  @Override
  public BroadDataSourceImpl get() {
    return newInstance();
  }

  public static TestDataSourceImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BroadDataSourceImpl newInstance() {
    return new BroadDataSourceImpl();
  }

  private static final class InstanceHolder {
    private static final TestDataSourceImpl_Factory INSTANCE = new TestDataSourceImpl_Factory();
  }
}