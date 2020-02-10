package com.example.maptest.presenter

import com.example.maptest.contract.ContractInterface
import com.example.maptest.model.MapsModel

class MapsPresenter(var view: ContractInterface.View, model: MapsModel): MapsModel.OnMapsModelListener {

    init {
        view.initView()
        model.mapsModel(this)
    }

    override fun onFailure(result: String) {
        view.updateErrorViewData(result)
    }

    override fun onResponse(result: String) {
        view.updateViewData(result)
    }

}