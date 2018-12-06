package @packageName@;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.cognifide.qa.bb.junit5.guice.Modules;

import com.cognifide.qa.bb.modules.BobcatRunModule;

import @packageName@.pageobjects.WikipediaPage;
import @packageName@.pageobjects.DefinitionPage;

@Modules(BobcatRunModule.class)
public class WikipediaTest {

  private static final String SEARCH_QUERY = "hello world";
  private static final String HEADING = "\"Hello, World!\" program";

  @Inject
  private BobcatPageFactory bobcatPageFactory;

  @Inject
  private DefinitionPage definitionPage;

  @Tag("desktop")
  @Test
  public void wikipediaSearchTest() {
    WikipediaPage homePage = bobcatPageFactory
        .create("https://en.wikipedia.org", WikipediaPage.class);
    homePage.open().getSearchComponent().searchForQuery(SEARCH_QUERY);
    assertThat(definitionPage.getHeading(), is(HEADING));
  }

  @Tag("mobile")
  @Test
  public void wikipediaSearchMobileTest() {
    WikipediaPage homePage = bobcatPageFactory
        .create("https://en.m.wikipedia.org", WikipediaPage.class);
    homePage.open().openSearchOverlay().getSearchOverlayComponent().searchForQuery(SEARCH_QUERY);
    assertThat(definitionPage.getHeading(), is(HEADING));
  }
}
