package com.theladders.solid.lsp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A wrapper that allows some properties to be overriden on a per-request basis.
 *
 * @author Zhi-Da Zhong &lt;zz@theladders.com&gt;
 */

public class DynamicEnvironment extends Environment
{
  private final Environment         base;
  private final Map<String, String> keyMap; // map insecure prop names to secure ones

  public DynamicEnvironment(Environment base, Map<String, String> propKeyMap)
  {
    this.base = base;
    this.keyMap = propKeyMap;
  }

  public Collection<String> values()
  {
    // TODO remove masked values
    // TODO join local instance values
    return base.values();
  }

  /**
   * This method uses a mapped version of the given key to access first its own Map then its
   * underlying Map.
   *
   * @param key
   *          An environment key like "home"
   * @return The value for the given key after mapping (e.g. "home" might be mapped to "secureHome")
   */


  public String get(String key)
  {
    String realKey = keyMap.get(key);
    String value = super.get(realKey != null ? realKey : key);
    if (value == null)
    {
      return base.get(realKey != null ? realKey : key);
    }
    return value;
  }


  public Set<Map.Entry<String, String>> entrySet()
  {
    Set<Map.Entry<String, String>> entrySet = new HashSet<>(super.entrySet());
    entrySet.addAll(base.entrySet());
    return Collections.unmodifiableSet(entrySet);
  }


  public Set<String> keySet()
  {
    Set<String> keySet = new HashSet<>(super.keySet());
    keySet.addAll(keyMap.keySet());
    keySet.addAll(base.keySet());
    return Collections.unmodifiableSet(keySet);
  }
}
