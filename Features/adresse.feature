Feature: Modifier l'adresse d'un abonne
    
   Scenario: Modification de l'adresse d'un abonne residant en France sans date d'effet
      Given  Un abonne de nom "Jack" et adresse "Nice" avec une adresse principale active en France      
      When   Le conseiller connecte à canal modifie l'adresse "Paris" de l'abonne 2 sans date d'effet
      Then   L'adresse "Paris" de l'abonne 2 modifiee est enregistree sur l'ensemble des contrats de l'abonne
      And    Un mouvement de modification d'adresse est cree le "29/09/2019" par "Sara BENKOUIDER"