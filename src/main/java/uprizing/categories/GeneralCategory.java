package uprizing.categories;

import uprizing.category.Category;
import uprizing.category.CategoryBuilder;
import uprizing.category.SubCategory;
import uprizing.setting.BooleanSetting;
import uprizing.settings.GlassRenderingSetting;

public class GeneralCategory extends Category {

	public GeneralCategory() {
		super("General");

		addSubCategory(new SubCategory("General", new CategoryBuilder()
			.add(new BooleanSetting("Chat Background"))
			.add(new GlassRenderingSetting())));

		addSubCategory(new SubCategory("Scoreboard", new CategoryBuilder()
			.add(new BooleanSetting("Scoreboard Scores"))
			.add(new BooleanSetting("Scoreboard Text Shadow"))));
	}
}