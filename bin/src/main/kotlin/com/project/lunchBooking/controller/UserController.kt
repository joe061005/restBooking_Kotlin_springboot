package com.project.lunchBooking.controller

import com.project.lunchBooking.errorHandler.ErrorResponse
import com.project.lunchBooking.model.Role
import com.project.lunchBooking.model.User
import com.project.lunchBooking.service.UserService
import io.jsonwebtoken.Jwts
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("api/v1/user")
class UserController(private val userService: UserService) {

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): ResponseEntity<User>{
        return ResponseEntity(userService.saveUser(user), HttpStatus.CREATED)
    }

    @GetMapping("/user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<ErrorResponse>{
        if(jwt == null){
            return ResponseEntity(ErrorResponse(message = "unauthorized"), HttpStatus.OK)
        }

        val id = Jwts.parser().setSigningKey("userLogin").parseClaimsJws(jwt).body.toString()

        return ResponseEntity(ErrorResponse(message = "id"), HttpStatus.OK)
    }

    @PostMapping("/addUsers")
    fun addUsers(@RequestBody users: List<User>): List<User>{
        return userService.saveUsers(users)
    }

    @GetMapping("/users")
    fun findAllUsers(): List<User>{
        return userService.getUsers()
    }

    @GetMapping("/userById/{id}")
    fun findUserById(@PathVariable id: Int): User?{
        return userService.getUserById(id)
    }

    @GetMapping("/user/{username}")
    fun findUserByName(@PathVariable username: String): User?{
        return userService.getUserByUsername(username)
    }

    @PutMapping("/user/update")
    fun updateUser(@RequestBody user: User): User?{
        return userService.updateUser(user)
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Int): String{
        return userService.deleteUser(id)
    }
    
    @PostMapping
    fun saveRole(@RequestBody role: Role): ResponseEntity<Role>{
        return ResponseEntity.ok().body(userService.saveRole(role))
    }





    

}