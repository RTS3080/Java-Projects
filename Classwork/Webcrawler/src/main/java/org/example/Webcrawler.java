package org.example;

import org.jsoup.*;

import java.io.IOException;
import java.util.*;


public class Webcrawler {
    Set<String> visited;
    String domain;
    Thread[] threads;
    public Webcrawler(String domain, int numThreads) {
        this.domain = domain;
        threads = new Thread[numThreads];
        visited = Collections.synchronizedSet(new HashSet<>());
    }

}
class WebcrawlerThread extends Thread{
    String[] urls;
    Set<String> vis;
    public WebcrawlerThread(String[] urls, int start, int end, Set<String> vis) {
        this.urls = new String[end - start];
        System.arraycopy(urls, start, urls, 0, end - start);
        this.vis = vis;
    }
    public void run(){
        for(String url : urls){
            Connection doc = Jsoup.connect(url);


        }
    }

}
