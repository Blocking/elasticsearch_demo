package com.example.demo;

import java.util.Iterator;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Movie;
import com.example.demo.repoistory.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void testSearch(){
		String queryString="Nolan";//搜索关键字
		QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
		Iterable<Movie> searchResult = movieRepository.search(builder);
		Iterator<Movie> iterator = searchResult.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
