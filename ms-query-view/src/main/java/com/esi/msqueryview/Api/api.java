package com.esi.msqueryview.Api;

import com.esi.coreapi.command.RemoveEtudiantCommand;
import com.esi.msqueryview.entities.EtudiantViewE;
import com.esi.msqueryview.entities.EtudiantView;
import com.esi.msqueryview.entities.CartebibView;
import com.esi.msqueryview.entities.CarteViewRepository;
import com.esi.msqueryview.entities.VirementViewRepository;
import com.esi.msqueryview.entities.VirementView;


import com.esi.msqueryview.entities.EtudiantViewRepositoryE;
import com.esi.msqueryview.entities.EtudiantViewRepository;
import com.esi.msqueryview.entities.EtudiantCompletViewRepository;
import com.esi.msqueryview.entities.EtudiantCompletView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("query")
    public class api {

    @Autowired
    EtudiantViewRepositoryE etudiantViewRepositoryE ;
    @Autowired
    EtudiantViewRepository etudiantViewRepository ;
    @Autowired
    CarteViewRepository carteViewRepository;
    @Autowired
    VirementViewRepository virementViewRepository ;
    @Autowired
    EtudiantCompletViewRepository etudiantCompletViewRepository ;



        @GetMapping("/etudiantprojectionE/{id}")

        public EtudiantViewE getEtudiantEById(@PathVariable Long id ){

            return etudiantViewRepositoryE.findById(id).get();}


        @GetMapping("/etudiantprojection/{id}")

        public EtudiantView getEtudiantById(@PathVariable Long id ){

         return etudiantViewRepository.findById(id).get();}




        @GetMapping(value ="/etudiantprojectionE")

        public List<EtudiantViewE> getEtudiantViewE(){
            return etudiantViewRepositoryE.findAll();}


    @GetMapping(value ="/etudiantprojection")

    public List<EtudiantView> getEtudiantView(){
        return etudiantViewRepository.findAll();}



    @GetMapping(value="/hello" )
     public String sayHello() {

        return "Hello there!";
     }



    @GetMapping("/etudiantCompletprojection/{id}")

    public EtudiantCompletView getEtudiantCompletViewById(@PathVariable Long id ){

        return etudiantCompletViewRepository.findById(id).get();}


    @GetMapping(value ="/etudiantCompletprojection")

    public List<EtudiantCompletView> getEtudiantCompletView(){
        return etudiantCompletViewRepository.findAll();}



   /* @GetMapping("/virementprojection/{id}")

    public VirementView getVirementById(@PathVariable Long id ){

        return virementViewRepository.findById(id).get();}




    @GetMapping(value ="/virementprojection")

    public List<VirementView> getVirement(){
        return virementViewRepository.findAll();}*/



    @GetMapping("/cartebibprojection/{id}")

    public CartebibView getCartebibById(@PathVariable Long id ){

        return carteViewRepository.findById(id).get();}








    @GetMapping(value ="/virementprojection")

    public List<VirementView> getVirement(){
        return virementViewRepository.findAll();}


    @GetMapping("/virementprojection/{id}")

    public VirementView getVirementById (@PathVariable Long id ){

        return virementViewRepository.findById(id).get();}






}

















