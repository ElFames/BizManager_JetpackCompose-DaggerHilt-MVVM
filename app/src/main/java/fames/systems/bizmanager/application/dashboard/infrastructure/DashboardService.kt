package fames.systems.bizmanager.application.dashboard.infrastructure

import fames.systems.bizmanager.application.dashboard.domain.models.Filter
import fames.systems.bizmanager.domain.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardService @Inject constructor(
    private val sessionService: Session,
    private val dashboardAPI: DashboardAPI
) {
    private val myToken get() = sessionService.getCurrentToken()
    private val authHeader = "Bearer $myToken"

    suspend fun getNumOfSales(filter: Filter): Int {
        return when(filter) {
            Filter.DIA -> dashboardAPI.getNumOfSalesDay("dashboard/numOfSales/day", authHeader).body() ?: -1
            Filter.SEMANA -> dashboardAPI.getNumOfSalesWeek("dashboard/numOfSales/week", authHeader).body() ?: -1
            Filter.MES -> dashboardAPI.getNumOfSalesMonth("dashboard/numOfSales/month", authHeader).body() ?: -1
        }
    }
    suspend fun getProfit(filter: Filter): Double {
        return when(filter) {
            Filter.DIA -> dashboardAPI.getProfitDay("dashboard/profit/day", authHeader).body() ?: -1.0
            Filter.SEMANA -> dashboardAPI.getProfitWeek("dashboard/profit/week", authHeader).body() ?: -1.0
            Filter.MES -> dashboardAPI.getProfitMonth("dashboard/profit/month", authHeader).body() ?: -1.0
        }

    }
    suspend fun getExpenses(filter: Filter): Double {
        return when(filter) {
            Filter.DIA -> dashboardAPI.getExpensesDay("dashboard/expenses/day", authHeader).body() ?: -1.0
            Filter.SEMANA -> dashboardAPI.getExpensesWeek("dashboard/expenses/week", authHeader).body() ?: -1.0
            Filter.MES -> dashboardAPI.getExpensesMonth("dashboard/expenses/month", authHeader).body() ?: -1.0
        }

    }
    suspend fun getIncome(filter: Filter): Double {
        return when(filter) {
            Filter.DIA -> dashboardAPI.getIncomeDay("dashboard/income/day", authHeader).body() ?: -1.0
            Filter.SEMANA -> dashboardAPI.getIncomeWeek("dashboard/income/week", authHeader).body() ?: -1.0
            Filter.MES -> dashboardAPI.getIncomeMonth("dashboard/income/month", authHeader).body() ?: -1.0
        }

    }


}