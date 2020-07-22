class RxDrug:
    def __init__(self, name, rx_ID):
        self.name = name
        self.rx_ID = rx_ID
        self.description = ''
        self.interactions_list = []

        

    def add_interactions(self, other_drugs):
        '''Function: add interactions
           Input: other drugs
           returns: nothing
           Does: iterates interactions list to check if other drug
                 is a part of list and if not then appending that element
        '''
        for element in other_drugs:
            if other_drugs not in self.interactions_list:
                self.interactions_list.append(other_drugs)

    def check_interaction(self, other_drugs):
        '''Function: check interactions
           Input: other drugs
           returns: list of drugs that interact with another prescription
           Does: check if element in interactions list and append to
                 a different list
        '''
        new_list = []
        for element in self.interactions_list:
            if element in self.interactions_list:
                new_list.append(element)
        return new_list


    def set_description(self, description):
        self.description = description

    def __str__(self):
        return(self.description)
