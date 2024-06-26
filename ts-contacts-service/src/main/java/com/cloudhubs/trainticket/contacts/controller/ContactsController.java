package com.cloudhubs.trainticket.contacts.controller;

import com.cloudhubs.trainticket.contacts.entity.Contacts;
import com.cloudhubs.trainticket.contacts.util.Response;
import com.cloudhubs.trainticket.contacts.service.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/contactservice")
public class ContactsController {


    @Autowired
    private ContactsService contactsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);

    @GetMapping(path = "/contacts/welcome")
    public String home() {
        return "Welcome to [ Contacts Service ] !";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/contacts")
    public HttpEntity getAllContacts(@RequestHeader HttpHeaders headers) {
        ContactsController.LOGGER.info("[getAllContacts][Get All Contacts]");
        return ok(contactsService.getAllContacts(headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/contacts")
    public ResponseEntity<Response> createNewContacts(@RequestBody Contacts aci/*,
                                                      @RequestHeader HttpHeaders headers*/) {
        ContactsController.LOGGER.info("[createNewContacts][VerifyLogin Success]");
        return new ResponseEntity<>(contactsService.create(aci, null), HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/contacts/{contactsId}")
    public HttpEntity deleteContacts(@PathVariable String contactsId, @RequestHeader HttpHeaders headers) {
        return ok(contactsService.delete(contactsId, headers));
    }


    @CrossOrigin(origins = "*")
    @PutMapping(path = "/contacts")
    public HttpEntity modifyContacts(@RequestBody Contacts info/*, @RequestHeader HttpHeaders headers*/) {
        ContactsController.LOGGER.info("[Contacts modifyContacts][Modify Contacts] ContactsId: {}", info.getId());
        return ok(contactsService.modify(info, null));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/contacts/account/{accountId}")
    public HttpEntity findContactsByAccountId(@PathVariable String accountId, @RequestHeader HttpHeaders headers) {
        ContactsController.LOGGER.info("[findContactsByAccountId][Find Contacts By Account Id][accountId: {}]", accountId);
        ContactsController.LOGGER.info("[ContactsService][VerifyLogin Success]");
        return ok(contactsService.findContactsByAccountId(accountId, headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/contacts/{id}")
    public HttpEntity getContactsByContactsId(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        ContactsController.LOGGER.info("[ContactsService][Contacts Id Print][id: {}]", id);
        ContactsController.LOGGER.info("[ContactsService][VerifyLogin Success]");
        return ok(contactsService.findContactsById(id, headers));
    }



}
