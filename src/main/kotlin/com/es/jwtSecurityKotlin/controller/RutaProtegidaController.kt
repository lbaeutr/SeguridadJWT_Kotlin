package com.es.jwtSecurityKotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rutas_protegidas")
class RutaProtegidaController {


    @GetMapping("/recurso1")
    fun getRecursoProtegidoUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    //
    @PostMapping("/recurso2")
    fun postRecursoProtegidoDos(@RequestBody requestBody: Map<String, Any>): ResponseEntity<String> {
        // Procesar el requestBody según sea necesario
        return ResponseEntity.ok("Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75")
    }



}