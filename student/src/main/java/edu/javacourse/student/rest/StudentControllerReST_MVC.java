package edu.javacourse.student.rest;

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * implements ReST Spring
 */
@RestController
@RequestMapping(path = "/student2")
public class StudentControllerReST_MVC {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<StudentResponse> getStudentInfo(@RequestBody StudentRequest request){
        return studentService.getStudentInfo(request);
    }

    @GetMapping(path = "/check")
    public String checkAdmin(){
        return "Rest Service is working";
    }

    @GetMapping(path = "/params/{checkId}") //  /{param1}/{param2} можно передавать множество параметров
    public String checkParams(@PathVariable(value = "checkId",required = true) Long checkId, @RequestParam("comment") String comment){ //@PathVariable(value = "checkId",required = true) - можно указать обязательный ли параметр
        return checkId + ":" + comment;
        //http://localhost:8080/student-1.0/mvc/student2/params/555?comment=TEST
    }

    @PostMapping(path = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadPhoto(@RequestParam("comment") String comment,
                              @RequestParam("photoFile")MultipartFile photoFile){
        try (InputStream is = photoFile.getInputStream()){
            return "Comment:" + comment + "Name:" + photoFile.getName() + " File Name:" + photoFile.getOriginalFilename() + ", Size:" + is.available();
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}

/**
 * {
 * "lastName":"Last",
 * "firstName":"First",
 * "middleName":"Middle",
 * "dateOfBirth":"12.04.2000",
 * "passportSerial":"1111",
 * "passportNumber":"222222",
 * "passportDate":"30.04.2016"
 *         }
 */
