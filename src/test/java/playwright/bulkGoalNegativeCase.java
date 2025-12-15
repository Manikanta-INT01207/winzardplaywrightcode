package playwright;

import base.BaseClass;

public class bulkGoalNegativeCase extends BaseClass{

	public static void main(String[] args) {

	 initializer();
	 page.navigate("https://capgemini.247hrm.co/");
		page.locator("#user-name").fill("anirudha@interbiz.in");
		page.locator("#password").fill("Winzard@2024");
		page.locator("#validation-user-btn").click();
		page.locator("//button[@type='button']").click();
		page.locator("//span[text()='Goal Achiever']").click();
		page.getByText("Bulk Goals").click();
		page.getByText("+ Create Bulk Goals").click();

		
	}

}
