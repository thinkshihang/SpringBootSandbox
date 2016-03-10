package com.hang.sandbox.controller;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/sql")
public class SQLController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getSQL(@RequestParam int id) throws SQLException {
        if (id == 1) {
            return "select * from table where id = " + id;
        } else {
            throw new SQLException();
        }
    }
}
