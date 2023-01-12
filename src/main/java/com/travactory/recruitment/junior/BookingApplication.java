package com.travactory.recruitment.junior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.H2)
//				.build();
//	}
//	@Primary
//	@Bean(name = "bookingsDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource-bookings")
//	public DataSource flightEngineDataSource() {
//		return DataSourceBuilder.create().build();
//	}

}
