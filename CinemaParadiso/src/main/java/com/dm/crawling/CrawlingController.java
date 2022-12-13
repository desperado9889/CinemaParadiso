package com.dm.crawling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingController {
	public void Crawling(ArrayList<MovieDTO> mlist) throws Exception {
		String url= "http://www.cgv.co.kr/movies/?lt=1&ft=0"; //크롤링할 url지정
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
		Elements tmp;
		String rank=null;
		String title=null;
		String poster=null;
		String movie_code=null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Elements element = doc.select("div.sect-movie-chart"); 
		
		for(int i=0; i<19; i++) {
			tmp=element.select("strong.rank");
			System.out.println(tmp.get(i).text());
			rank=tmp.get(i).text();
			
			
			tmp=element.select("strong.title");
			System.out.println(tmp.get(i).text());
			title=tmp.get(i).text();
			
			
			tmp=element.select("img");
			System.out.println(tmp.get(i).attr("src"));
			poster=tmp.get(i).attr("src");
			
			tmp=element.select("img");
			movie_code=poster.substring(52,57);
			System.out.println(movie_code);
			
			mlist.add(new MovieDTO(rank,title,poster,movie_code));
			
		}
		System.out.println("Crawling complete");
	}
}
