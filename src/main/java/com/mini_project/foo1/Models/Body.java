package com.mini_project.foo1.Models;

import java.util.List;
import java.util.Map;

public abstract class Body {
    private String get;
    private int results;
    private List<String> error;
    private Map<String,String> paging;

    public Body(String get, int results, List<String> error, Map<String, String> paging) {
        this.get = get;
        this.results = results;
        this.error = error;
        this.paging = paging;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public Map<String, String> getPaging() {
        return paging;
    }

    public void setPaging(Map<String, String> paging) {
        this.paging = paging;
    }
}
