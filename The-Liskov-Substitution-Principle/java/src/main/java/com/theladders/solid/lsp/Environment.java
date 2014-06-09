package com.theladders.solid.lsp;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Environment //extends HashMap<Object, Object>
{
  public static final String KEY_EMAIL_DOMAIN = "emaildomain";
  private Map<String, String> environments;

  public Environment()
  {
    environments = new HashMap<>();
  }

  public String get(String key)
  {
    return environments.get(key);
  }

  public void put(String key, String value)
  {
    environments.put(key, value);
  }

  public Set<Map.Entry<String, String>> entrySet()
  {
    return environments.entrySet();
  }

  public Set<String> keySet()
  {
    return  environments.keySet();
  }

  public Collection<String> values()
  {
    return environments.values();
  }
  public String toString()
  {
    return environments.toString();
  }
  /**
   * Convenience method that returns the admin email address for this ladder.
   *
   * @return email address or "" if either the user or domain is not defined
  */
  public String getAdminEmail()
  {
    String user = getString("admin");
    String domain = getString(KEY_EMAIL_DOMAIN);

    return user.length() > 0 && domain.length() > 0 ? user + "@" + domain : "";
  }

  public String getString(String key)
  {
    Object val = get(key);
    return (val != null) ? val.toString().trim() : "";
  }
}
