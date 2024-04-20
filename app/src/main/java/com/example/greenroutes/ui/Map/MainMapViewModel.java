package com.example.greenroutes.ui.Map;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.greenroutes.data.RouteRepositoryImpl;
import com.example.greenroutes.domain.GetRoutesListUseCase;
import com.example.greenroutes.domain.entites.ItemRouteEntity;

import java.util.List;

import okhttp3.Route;

public class MainMapViewModel extends ViewModel {
    private final MutableLiveData<State> mutableStateLiveData = new MutableLiveData<>();
    public final LiveData<State> stateLiveData = mutableStateLiveData;

    private final GetRoutesListUseCase getRoutesListUseCase = new GetRoutesListUseCase(
            RouteRepositoryImpl.getInstance()
    );
    /*public void MainMapView(){
        update();
    }*/
    /*public void update(){
        mutableStateLiveData.setValue(new State(null,null));
    }*/
    public class State{
        @Nullable
        private final String errorMessage;

        @Nullable
        private final List<ItemRouteEntity> items;

        public State(@Nullable String errorMessage, @Nullable List<ItemRouteEntity> items) {
            this.errorMessage = errorMessage;
            this.items = items;
        }

        @Nullable
        public String getErrorMessage() {
            return errorMessage;
        }

        @Nullable
        public List<ItemRouteEntity> getItems() {
            return items;
        }
    }
}
