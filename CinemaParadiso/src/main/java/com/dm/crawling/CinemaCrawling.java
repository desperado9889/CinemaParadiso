package com.dm.crawling;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CinemaCrawling {
	public void InfoCrawling(ArrayList<MovieDTO> milist) throws Exception{
		String url = "http://www.cgv.co.kr/movies/detail-view/?midx=86481"; //크롤링할 url지정
		String url_s= "https://movie.naver.com/movie/bi/mi/photoView.naver?code=222301";
		String url2 = "https://movie.naver.com/movie/bi/mi/basic.naver?code=222301";
		String url3 = "https://movie.naver.com/movie/bi/mi/detail.naver?code=222301";
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
		Document doc_s = null;
		Document naver = null;
		Document naver_cast = null;
		try {
			doc = Jsoup.connect(url).get();
			doc_s=Jsoup.connect(url_s).get();
			naver=Jsoup.connect(url2).get();
			naver_cast=Jsoup.connect(url3).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//보낼 정보: 포스터(String), 제목(String), 관객수(String), 관람등급(INT), 러닝타임(INT), 개봉일(DATE), 감독(String), 출연진(String), 시놉시스(String)
		
		Elements pst = doc.select("span.thumb-image img");	
		Elements title_e = doc.select("div.title strong");	//제목
		Elements count_e = naver.select("span.count");		//관객수(네이버)
		Elements specO = doc.select("div.spec dd.on");
		Elements element = doc.select("div.sect-story-movie"); 
		Elements casts = naver_cast.select("div.p_info a.k_name");
		Elements director_e = naver_cast.select("div.dir_product a.k_name");
		Elements stillcut_e = doc_s.select("div.viewer_img img");
		Elements genre_e= doc.select("div.spec dt");
		
		String poster = pst.attr("src"); //포스터
		String info=specO.text();
		String information=info.replaceAll("[^\\d]", "");	//숫자만 추출
		String pg_s=information.substring(0,2);			//관람등급
		String runningTime_s=information.substring(2,5);	//영화 시간
		String onScreen=information.substring(5,13);	//개봉일 가져오기
		String onScreenY=onScreen.substring(0,4);	//year
		String onScreenM=onScreen.substring(4,6);	//month
		String onScreenD=onScreen.substring(6,8);	//date
		String date=onScreenY+"-"+onScreenM+"-"+onScreenD;//입력할 개봉일
		
		int running_time=Integer.parseInt(runningTime_s);
		int pg=Integer.parseInt(pg_s);
		String title =title_e.text();
		String audience ="누적관객수 : "+count_e.text();
		String director=director_e.text();	//감독(네이버)
		String cast=casts.text();	//출연진(네이버)
		String synopsis=element.text();
		String movie_code=poster.substring(52,57);
		String stillcut = stillcut_e.attr("src");
		String[] genre_a = genre_e.text().split(" ");
		String genre = genre_a[7];
	
		milist.add(new MovieDTO(title, poster, audience, pg, running_time, date, director, cast, synopsis, movie_code, stillcut, genre));
		
		
		System.out.println(poster);
		System.out.println(title);	
		System.out.println(audience);
		System.out.println(pg);
		System.out.println(running_time);
		System.out.println(date);
		System.out.println(director);
		System.out.println(cast);
		System.out.println(synopsis);
		System.out.println(stillcut);
		System.out.println(genre);
		
		System.out.println("Crawling complete");
	}
}