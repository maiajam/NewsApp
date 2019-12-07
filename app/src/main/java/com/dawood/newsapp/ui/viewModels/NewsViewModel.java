package com.dawood.newsapp.ui.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dawood.newsapp.helper.Utils;
import com.dawood.newsapp.models.NewsResponseModel;
import com.dawood.newsapp.data.model.SourcesModel;
import com.dawood.newsapp.data.repo.NewsRepo;


public class NewsViewModel extends ViewModel {

    private MutableLiveData<NewsResponseModel> mutableLiveData;
    private MutableLiveData<NewsResponseModel> filterdNewsLiveData;
    private MutableLiveData<SourcesModel> sourcesLiveData;
    private NewsRepo newsRepository = NewsRepo.getInstance();
    String page;

    public NewsViewModel() {
    }

    public void init(String page, String topic) {
        mutableLiveData = newsRepository.getNews(Utils.ApiKey, topic, page + "");
        sourcesLiveData = newsRepository.getNewsSources(Utils.ApiKey);
    }


    public LiveData<NewsResponseModel> getNewsRepository() {
        return mutableLiveData;
    }

    public LiveData<NewsResponseModel> getFilterdNewsRepository(String country, String source, String page) {
        filterdNewsLiveData = newsRepository.getFilterdNews(Utils.ApiKey, country, source, page);
        return filterdNewsLiveData;
    }


    public LiveData<SourcesModel> getSources() {
        return sourcesLiveData;
    }
}
