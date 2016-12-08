package net.map;

import com.monitorjbl.json.JsonViewSupportFactoryBean;
import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.domain.Type;
import net.map.repository.CategoryRepository;
import net.map.repository.MapPointRepository;
import net.map.repository.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class MapApplication {

	@Bean
	CommandLineRunner runner(MapPointRepository mapPointRepository, CategoryRepository categoryRepository, TypeRepository typeRepository) {
		return args -> {
			Type type = new Type("Capel" , "icon12");
			typeRepository.save(type);
			//create categories
			Category category = new Category("Restaurants", "Interesting", "icon");
			Category category2 = new Category("POI", "Very interesting", "icon2");
			Category category3 = new Category("Attractions", "Very interesting", "icon3");
			Category category4 = new Category("Monuments", "Very interesting", "icon4");
			Category category5 = new Category("Churches", "Very interesting", "icon5");
			Category category6 = new Category("Nature", "Very interesting", "icon6");
			Category category7 = new Category("GeoCache", "Very interesting", "icon7");
			Category category8 = new Category("Hotels", "Very interesting", "icon8");
			Category category9 = new Category("Shops", "Very interesting", "icon9");
			Category category10 = new Category("Parks", "Very interesting", "icon10");
			categoryRepository.save(category);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			categoryRepository.save(category5);
			categoryRepository.save(category6);
			categoryRepository.save(category7);
			categoryRepository.save(category8);
			categoryRepository.save(category9);
			categoryRepository.save(category10);
			MapPoint point1 = new MapPoint("Point 1", "Some point", category, 56.1, 17);
			point1.setType(type);
			MapPoint point2 = new MapPoint("Point 2", "Some point", category, 56.2, 17);
			point2.setType(type);
			MapPoint point3 = new MapPoint("Point 3", "Some point", category, 56.4, 17);
			MapPoint point4 = new MapPoint("Point 4", "Some point", category, 56.3, 17);
			MapPoint point5 = new MapPoint("Point 5", "Some point", category2, 56.33, 17);
			MapPoint point6 = new MapPoint("Point 6", "Some point", category2, 56.33, 17);
			MapPoint point7 = new MapPoint("Point 7", "Some point", category2, 56.33, 17);
			MapPoint point8 = new MapPoint("Point 8", "Some point", category2, 56.33, 17);
			MapPoint point9 = new MapPoint("Point 9", "Some point", category2, 56.33, 17);
			MapPoint point10 = new MapPoint("Point 10", "Some point", category2, 56.33, 17);
			MapPoint point11 = new MapPoint("Point 11", "Some point", category2, 56.33, 17);
			MapPoint point12 = new MapPoint("Point 12", "Some point", category2, 56.33, 17);
			MapPoint point13 = new MapPoint("Point 13", "Some point", category2, 56.33, 17);
			MapPoint point14 = new MapPoint("Point 13", "Some point", category3, 45.33, 17);
			MapPoint point15 = new MapPoint("Point 13", "Some point", category3, 46.33, 17);
			MapPoint point16 = new MapPoint("Cool", "Some point", category3, 46.323, 17.5);
			MapPoint point17 = new MapPoint("Cool", "Some point", category4, 36.3123, 17.5);
			MapPoint point18 = new MapPoint("Cool", "Some point", category4, 36.3223, 17.5);
			MapPoint point19 = new MapPoint("Cool", "Some point", category4, 36.3323, 17.5);
			MapPoint point20 = new MapPoint("Cool", "Some point", category4, 36.3423, 17.5);

			MapPoint point21 = new MapPoint("Cool", "Some point", category5, 36.3123, 17.5);
			MapPoint point22 = new MapPoint("Cool", "Some point", category5, 36.3223, 17.5);
			MapPoint point23 = new MapPoint("Cool", "Some point", category5, 36.3323, 17.5);
			MapPoint point24 = new MapPoint("Cool", "Some point", category5, 36.3423, 17.5);

			MapPoint point25 = new MapPoint("Cool", "Some point", category6, 36.3123, 17.5);
			MapPoint point26 = new MapPoint("Cool", "Some point", category6, 36.3223, 17.5);
			MapPoint point27 = new MapPoint("Cool", "Some point", category6, 36.3323, 17.5);
			MapPoint point28 = new MapPoint("Cool", "Some point", category6, 36.3423, 17.5);
			MapPoint point29 = new MapPoint("Cool", "Some point", category6, 36.3123, 17.5);

			MapPoint point30 = new MapPoint("Cool", "Some point", category7, 36.3223, 17.5);
			MapPoint point31 = new MapPoint("Cool", "Some point", category7, 36.3323, 17.5);
			MapPoint point32 = new MapPoint("Cool", "Some point", category7, 36.3423, 17.5);

			MapPoint point33 = new MapPoint("Cool", "Some point", category8, 36.3123, 17.5);
			MapPoint point34 = new MapPoint("Cool", "Some point", category8, 36.3223, 17.5);
			MapPoint point35 = new MapPoint("Cool", "Some point", category8, 36.3323, 17.5);
			MapPoint point36 = new MapPoint("Cool", "Some point", category9, 36.3423, 17.5);

			MapPoint point37 = new MapPoint("Cool", "Some point", category8, 36.3123, 17.5);
			MapPoint point38 = new MapPoint("Cool", "Some point", category10, 36.3223, 17.5);
			MapPoint point39 = new MapPoint("Cool", "Some point", category10, 36.3323, 17.5);
			MapPoint point40 = new MapPoint("Cool", "Some point", category10, 36.3423, 17.5);



			mapPointRepository.save(point1);
			mapPointRepository.save(point2);
			mapPointRepository.save(point3);
			mapPointRepository.save(point4);
			mapPointRepository.save(point5);
			mapPointRepository.save(point6);
			mapPointRepository.save(point7);
			mapPointRepository.save(point8);
			mapPointRepository.save(point9);
			mapPointRepository.save(point10);
			mapPointRepository.save(point11);
			mapPointRepository.save(point12);
			mapPointRepository.save(point13);
			mapPointRepository.save(point14);
			mapPointRepository.save(point15);
			mapPointRepository.save(point16);
			mapPointRepository.save(point17);
			mapPointRepository.save(point18);
			mapPointRepository.save(point19);
			mapPointRepository.save(point20);
			mapPointRepository.save(point21);
			mapPointRepository.save(point22);
			mapPointRepository.save(point23);
			mapPointRepository.save(point24);
			mapPointRepository.save(point25);
			mapPointRepository.save(point26);
			mapPointRepository.save(point27);
			mapPointRepository.save(point28);
			mapPointRepository.save(point29);
			mapPointRepository.save(point30);
			mapPointRepository.save(point31);
			mapPointRepository.save(point32);
			mapPointRepository.save(point33);
			mapPointRepository.save(point34);
			mapPointRepository.save(point35);
			mapPointRepository.save(point36);
			mapPointRepository.save(point37);
			mapPointRepository.save(point38);
			mapPointRepository.save(point39);
			mapPointRepository.save(point40);

		};
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}
    @Bean
    public JsonViewSupportFactoryBean views() {
        return new JsonViewSupportFactoryBean();
    }

	public static void main(String[] args) {
		SpringApplication.run(MapApplication.class, args);
	}
}
