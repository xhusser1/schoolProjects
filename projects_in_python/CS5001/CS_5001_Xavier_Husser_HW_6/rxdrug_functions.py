from rxdrug import*

'''
Xavier Husser
CS 5001
Fall 2019
11/14/19
'''

DRUG_DICT = {}
def read_file(filename):
    '''Function: bag of letters
       Input: Frequency letter dictionary
       returns: a list of letters
       Does: iterate through the dictionary to append key in list
    '''
    infile = open(filename, 'r')
    n = infile.read()
    lst = n.splitlines()
    infile.close()
    return lst

def create_drugs():
    '''Function: create drugs
       Input: none
       returns: a dictionary containing  rx drug objects 
       Does: reads text file and parse by character to assign attributes
             to an information list with as variables then stores name of
             drug as key in dictionary and object as value then calls the
             description and add interactions methods from rx class so
             the object can be stored in dictionary
    '''
    try:
        drugs = read_file('rxcui_drugs.txt')
        for index in range(len(drugs)-1):
            drug = drugs[index]
            drug_info = drug.split('|')
            name = drug_info[0]
            ID = drug_info[1]
            description = drug_info[2]
            rxdrug = RxDrug(name,ID)
            DRUG_DICT[name] = rxdrug
            rxdrug.set_description(description)
            interactions = drug_info[3].split(',')
            for i in interactions:
                rxdrug.add_interactions(i)         
        return DRUG_DICT
    except OSError:
        print('Error reading file')
        return
def create_scripts():
    '''Function: create scripts
       Input: none
       returns: a match list of drugs
       Does: reads text file and parse by character to assign attributes
             to a person list with as variables then uses the name of patient
             as key to get value from dictionary then calls the
             check interactions method from rx class so
             to see if the match list meets specific conditionals for the
             print out which varies on a patient's current medication
    '''
    try:
        scripts = read_file('prescriptions.txt')
        for index in range(len(scripts)-1):
            script = scripts[index]
            person = script.split('|')
            name = person[0]
            condition = person[1]
            drugs = person[2].split(',')
            rx_to_check = DRUG_DICT[drugs[0]]
            match_list = rx_to_check.check_interaction(list(drugs[1:]))
            if len(match_list) == 1 and match_list[0] == '*':
                print('Checking prescription for ' + person[0] +
                      ' who suffers from ' + person[1] + '\n' + 'Current Rx: ' +
                      drugs[0] + '\n' +
                      "No serious drug interactions found in this Rx \n")
            elif len(match_list) > 0:
                print('Checking prescription for ' + person[0] +
                      ' who suffers from ' + person[1] + '\n' + 'Current Rx: '
                      + drugs[0] + '\n' +
                      "Warning: drug-drug interaction between " + drugs[0],
                      match_list[0] + '\n')
        return match_list
    except OSError:
        print('Error reading file')
        return   
