package com.caomei.cn.cmtool.bean;

import java.util.List;

/**
 * Created by zw on 2017/4/23.
 */
public class adc {


    /**
     * id : 5639
     * category : 1
     * name : Fotoapparat
     * owner : Fotoapparat
     * repo : Fotoapparat
     * ver : 7dee871fcc
     * stargazers : 4
     * watchers : 2
     * forks : 0
     * issues : 0
     * activity : {"commits":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,42,74,35,61,6],"dates":["May, 2016","May, 2016","May, 2016","May, 2016","May, 2016","Jun, 2016","Jun, 2016","Jun, 2016","Jun, 2016","Jul, 2016","Jul, 2016","Jul, 2016","Jul, 2016","Jul, 2016","Aug, 2016","Aug, 2016","Aug, 2016","Aug, 2016","Sep, 2016","Sep, 2016","Sep, 2016","Sep, 2016","Oct, 2016","Oct, 2016","Oct, 2016","Oct, 2016","Oct, 2016","Nov, 2016","Nov, 2016","Nov, 2016","Nov, 2016","Dec, 2016","Dec, 2016","Dec, 2016","Dec, 2016","Jan, 2017","Jan, 2017","Jan, 2017","Jan, 2017","Jan, 2017","Feb, 2017","Feb, 2017","Feb, 2017","Feb, 2017","Mar, 2017","Mar, 2017","Mar, 2017","Mar, 2017","Apr, 2017","Apr, 2017","Apr, 2017","Apr, 2017"]}
     */

    private int id;
    private int category;
    private String name;
    private String owner;
    private String repo;
    private String ver;
    private int stargazers;
    private int watchers;
    private int forks;
    private int issues;
    private ActivityEntity activity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public int getStargazers() {
        return stargazers;
    }

    public void setStargazers(int stargazers) {
        this.stargazers = stargazers;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public static class ActivityEntity {
        private List<Integer> commits;
        private List<String> dates;

        public List<Integer> getCommits() {
            return commits;
        }

        public void setCommits(List<Integer> commits) {
            this.commits = commits;
        }

        public List<String> getDates() {
            return dates;
        }

        public void setDates(List<String> dates) {
            this.dates = dates;
        }
    }
}
