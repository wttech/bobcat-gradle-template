package @packageName@;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import com.cognifide.qa.bb.RunWithJunit5;
import com.cognifide.qa.bb.junit5.guice.Modules;

import @packageName@.GuiceModule;
import @packageName@.pageobjects.WikipediaPage;
import @packageName@.pageobjects.DefinitionPage;

@RunWithJunit5
@Modules(GuiceModule.class)
public class WikipediaTest {

  private static final String SEARCH_QUERY = "hello world";
  private static final String HEADING = "\"Hello, World!\" program";

  @Inject
  private WikipediaPage homePage;

  @Inject
  private DefinitionPage definitionPage;

  @Test
  public void wikipediaSearchTest() {
    homePage.open().getSearchComponent().searchForQuery(SEARCH_QUERY);
    assertThat(definitionPage.getHeading(), is(HEADING));
  }
}
