//package com.holyinfantes.backend.application.courseorder;
//
//import com.holyinfantes.backend.domain.courseorder.CourseOrder;
//import com.holyinfantes.backend.domain.courseorder.exceptions.CourseAlreadyAdquiredException;
//import com.holyinfantes.backend.infrastructure.repository.courseorder.CourseOrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//public class CreateCourseOrder {
//
//    @Autowired
//    private CourseOrderRepository repository;
//
//    public Void createOrder (Long courseId) {
//
//        orderVerify(courseId);
//
//        saveInProcessOrder(courseId);
//
//        //ir a la pasarela de pago
//
//        //Actualizar el estado con "pagado" o "cancelado"
//
//        // no deveulve nada
//    }
//
//    private void orderVerify(Long courseId) {
//      //CourseOrder courseOrder = repository.findOrderByCourseIdAndUserId(courseId, userId);
//      //String state = courseOrder.getState();
//      //if (state.equals("adquired")) {
//      //  throw new CourseAlreadyAdquiredException("Course already adquired");
//      }
//    }
//
//    private void saveInProcessOrder(Long courseId) {
//
//        //CourseOrder courseOrder = new CourseOrder();
//        //courseOrder.setCourseId(courseId);
//        //courseOrder.setPurchasedAt(LocalDate.now());
//        //courseOrder.setState("In process");
//        //courseOrder.setUser();
//
//        //repository.save(courseOrder);
//    }
//}
