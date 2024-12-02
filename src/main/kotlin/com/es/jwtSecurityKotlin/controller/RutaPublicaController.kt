package com.es.jwtSecurityKotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rutas_publicas")
class RutaPublicaController {


    @GetMapping("/recurso1")
    fun getRecursoPublicoUno () : String {
        return "Este recurso puede ser accedido por cualquiera, es público \uD83D\uDE0E"
    }


    @PostMapping("/recurso2")
    fun postRecursoPublicoDos(@RequestBody requestBody: Map<String, Any>): ResponseEntity<String> {
        // Procesar el requestBody según sea necesario
        return ResponseEntity.ok("Este recurso puede ser accedido por cualquiera, es público \uD83D\uDE0E")
    }

    @PostMapping("/recurso3")
    fun postRecursoPublicoTres(@RequestBody requestBody: Map<String, Any>): ResponseEntity<String> {
        // Procesar el requestBody según sea necesario
        return ResponseEntity.ok("Este recurso puede ser accedido por cualquiera, es público \uD83D\uDE0E")
    }



}