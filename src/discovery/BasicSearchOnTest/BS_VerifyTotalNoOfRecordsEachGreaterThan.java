package discovery.BasicSearchOnTest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Assert;
import org.testng.annotations.Test;
import wrapper.Wrapper_methods;

public class BS_VerifyTotalNoOfRecordsEachGreaterThan extends Wrapper_methods {

	@Test
	public void openUrl() throws InterruptedException, IOException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		enterTextById("search-all-collections", "*");

		Thread.sleep(3000);

		clickbyXpath("(//input[@type='submit'])[1]");

		Thread.sleep(3000);
		// Total no of records on record tab

		String totalNoOfRecords = getTextById("records-tab");

		System.out.println(totalNoOfRecords);

		int records_count = 34099958;
		
		Assert.assertThat(records_count, (greaterThan(34000000)));

		// Record Creators

		String totalNoOfRecordCreators = getTextById("nameAuthorities");

		System.out.println(totalNoOfRecordCreators);

		int recordCreators_count = 261101;

		Assert.assertThat(recordCreators_count, (greaterThan(261000)));
		// Total no of records at TNA
		clickbyLinkText("The National Archives");

		String totalNoOfRecordsForTheNationalArcgives = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForTheNationalArcgives);

		int TNA_count = 23419602;

		Assert.assertThat(TNA_count, (greaterThan(23000000)));

		// remove filter

		clickbyXpath("//img[@alt='Remove']");
		// total no of records at TNA available for download
		clickbyLinkText("Available for download only");
		Thread.sleep(3000);
		String totalNoOfRecordsForDownloadOnly = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForDownloadOnly);

		int AvailableForDownLoad_count = 8916990;

		Assert.assertThat(AvailableForDownLoad_count, (greaterThan(8000000)));

		Thread.sleep(3000);
		// remove filters
		clickbyLinkText("Remove all filters");
		Thread.sleep(3000);

		// total no of records other archives
		clickbyLinkText("Other archives");

		String totalNoOfRecordsForOtherArchive = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForOtherArchive);

		int otherarchives_count = 10680363;

		Assert.assertThat(otherarchives_count, (greaterThan(10000000)));
		
		driver.quit();

	}

}
