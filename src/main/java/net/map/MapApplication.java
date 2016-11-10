package net.map;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.repository.CategoryRepository;
import net.map.repository.MapPointRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class MapApplication {

	@Bean
	CommandLineRunner runner(MapPointRepository mapPointRepository, CategoryRepository categoryRepository) {
		return args -> {

			//create categories
			Category category = new Category("Restaurants", "Interesting", "icon");
			Category category2 = new Category("POI", "Very interesting", "icon2");
			Category category3 = new Category("Attractions", "Very interesting", "icon3");
			Category category4 = new Category("Monuments", "Very interesting", "icon4");
			categoryRepository.save(category);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			MapPoint point1 = new MapPoint("Point 1", "Some point", category, 56.1, 17);
			MapPoint point2 = new MapPoint("Point 2", "Some point", category, 56.2, 17);
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

	public static void main(String[] args) {
		SpringApplication.run(MapApplication.class, args);
	}
}
