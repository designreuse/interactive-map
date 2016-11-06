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
			Category category2 = new Category("POI", "Very interesting", "icon");
			categoryRepository.save(category);
			categoryRepository.save(category2);
			MapPoint point1 = new MapPoint("Point 1", "Some point", category, 54, 17);
			MapPoint point2 = new MapPoint("Point 2", "Some point", category, 55, 17);
			MapPoint point3 = new MapPoint("Point 3", "Some point", category, 56, 17);
			MapPoint point4 = new MapPoint("Point 4", "Some point", category, 57, 17);
			MapPoint point5 = new MapPoint("Point 4", "Some point", category2, 53, 17);
			MapPoint point6 = new MapPoint("Point 4", "Some point", category2, 52, 17);
			mapPointRepository.save(point1);
			mapPointRepository.save(point2);
			mapPointRepository.save(point3);
			mapPointRepository.save(point4);
			mapPointRepository.save(point5);
			mapPointRepository.save(point6);

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
