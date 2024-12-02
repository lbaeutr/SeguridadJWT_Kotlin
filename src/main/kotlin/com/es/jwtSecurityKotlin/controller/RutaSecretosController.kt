package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
    @RequestMapping("/secretos_extra_confidenciales")
class RutaSecretosController {

    @GetMapping("/ficha1")
    fun getFichaUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios con el rol de luis \uD83D\uDE0E"
    }


}