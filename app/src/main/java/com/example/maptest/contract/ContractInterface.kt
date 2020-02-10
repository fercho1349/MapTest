package com.example.maptest.contract

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData(result: String)
        fun updateErrorViewData(result: String)
    }
}