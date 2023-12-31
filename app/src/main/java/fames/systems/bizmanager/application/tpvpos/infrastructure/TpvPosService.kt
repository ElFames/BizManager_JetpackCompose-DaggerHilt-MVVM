package fames.systems.bizmanager.application.tpvpos.infrastructure

import fames.systems.bizmanager.domain.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TpvPosService @Inject constructor(
    private val sessionService: Session
) {
    private val myToken get() = sessionService.getCurrentToken()


}