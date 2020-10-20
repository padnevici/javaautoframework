package com.auto;

import com.auto.page.objects.AbstractPage;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {

  private Map<String, AbstractPage> pages = new HashMap<String, AbstractPage>();

  public Map<String, AbstractPage> getPages() {
    return pages;
  }
}
