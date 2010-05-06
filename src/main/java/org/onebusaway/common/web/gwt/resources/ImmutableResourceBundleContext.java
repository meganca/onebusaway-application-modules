package org.onebusaway.common.web.gwt.resources;

import java.io.File;

public interface ImmutableResourceBundleContext {

  public String handleResource(String bundleName, String resourceName,
      String resourceKey, String resourceExtension, LocalResource resource);

  public String addContext(String url);

  public File getTempDir();
}
