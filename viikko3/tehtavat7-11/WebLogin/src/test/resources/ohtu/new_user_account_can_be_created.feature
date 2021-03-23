Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  too short username "mu" and a valid password is given
        Then  user is not created and error "username should have at least 3 characters" is reported 

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  valid username "myyraherra" and too short password "hip2" are given 
        Then  user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  new users password "herramyyra2" and password confirmation "herramyyra1" do not match
        Then  user is not created and error "password and password confirmation do not match" is reported   
