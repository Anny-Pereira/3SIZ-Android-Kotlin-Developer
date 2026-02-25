package br.com.heiderlopes.lotteryapp.navigation

sealed class Routes(val route: String){

    object Input: Routes ("input")

    object Result: Routes("result/{${Args.AMOUNT}}"){

        object Args{
            const val AMOUNT = "amount"
        }

        fun createRoute(amount : Int) = "result/$amount"
    }
}