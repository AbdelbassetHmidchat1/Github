import re


class Phonebook:
    def __init__(self, contactdetails=open("text2.txt", "r+"), contdict=None, list1=None):
        if list1 is None:
            list1 = []
        if contdict is None:
            contdict = {}
        self.contactdetails = contactdetails
        self.contdict = contdict
        self.list1 = list1

    def phonebook_menu(self):
        print(
            f"Phone book Menu\nEnter your choice:\n1: Add a new contact \n2: Remove an existing contact \n3: Look up a contact \n4: Update a contact phone number \n5: Display all contacts \n6: Delete all contacts  \n7: Exit phonebook ")

    def addcontacts(self):
        re1 = "^(\+212)([ \-_/]*)(\d[ \-_/]*){9}$"
        re2 = "(([1-2][0-9])|([1-9])|(3[0-1]))/((1[0-2])|([1-9]))/[0-9]{4}$"
        input1 = (input("enter the contact's name "))
        input1.capitalize()
        input2 = input("enter the contact's ID ")
        self.list1.append(input2)
        input3 = input("enter the contact's Date of birth (dd/mm/YYYY) required ")
        if re.search(re2, input3):
            print("the format of the birthday is correct: it'll be added to the contact's details")
            self.list1.append(input3)
        else:
            print("the format is incorrect : the birthday won't be added to the contact's details")
        input4 = input("enter the contact's number (+212 required) ")
        if re.search(re1, input4):
            print("the format of the number is correct: it'll be added to the contact's details")
            self.list1.append(input4)
        else:
            print("the format is incorrect : the number won't be added to the contact's details")
        self.contdict[input1] = self.list1
        input4 = input("enter the contact's category")
        self.list1.append(input4)

        for input1, self.list1 in self.contdict.items():
            self.contactdetails.write(input1.capitalize())
            self.contactdetails.write(str(self.list1) + "\n")


    def remove_contact(self):
        delcon = input("what's the name of the contact that you want to delete ")
        if delcon in self.contdict.keys():
            yesno = input("are you sure you want to delete this contact ? (Y/N)")
            if yesno == "Y":
                self.contdict.pop(delcon)
                for line in self.contactdetails:
                    for i in line:
                        if i == line:
                            line=""

                print("the contact has been removed successfully")



            else:
                print("the contact won't be deleted")
        else:
            print("there's no contact with that name in the phonebook")

    def look_contact(self):
        phonenamenumber = (input("what is the contact's name / phone number you're looking for"))
        if phonenamenumber in self.contdict.keys():
            for phonename in self.contdict:
                print("the user name is ", phonename, "and his details are", self.contdict[phonename])
        for key, values in self.contdict.items():
            for i in self.contdict.items():

                for g in values:
                    if g == phonenamenumber:
                        print("the user name is ", key, "and the contacts details are", values)
        if phonenamenumber not in self.contdict.keys():
            for i in self.contdict.values():
                print("there is no contact with this name")

        if self.contdict == {}:
            print("the phonebook is empty ")

    def update_contact(self):
        changecontact = input("please input the name of the contact that you want to change his phone number")
        try:
            changenumber = input("input the user's new number")
            self.contdict[f"{changecontact}"][4] = [changenumber]
        except IndexError:
            yesno2 = input(
                "you didn't put a valid number at first,you can't change the phone number now do you want to add it ? (Y/N)")
            if yesno2 == "Y":
                self.contdict[f"{changecontact}"].append(changenumber)
            if yesno2 == "N":
                print("the phone number is not added to user's details")
        print(self.contdict)

    def display_contact(self):
        print("the contacts are ")
        for i in self.contactdetails:
            print(i)

    def delete_contacts(self):
        yesno3 = input("are you sure you wanna delete the contacts ? (Y/N)")
        if yesno3 == "Y":
            self.contdict.clear()
            print("the contacts have been deleted successfully")
            self.contactdetails.truncate(0)
        if yesno3 == "N":
            print("no changes has been made")
        if yesno3 != "Y" and yesno3 != "N":
            print("you didn't type Y nor N ")

    def exit_phonebook(self):
        print("thanks for using the phonebook")
        quit()


phonebook1 = Phonebook()
phonebook1.phonebook_menu()


def choose():
    choice = int(input("choose a number"))
    if choice == 1:
        phonebook1.addcontacts()

    if choice == 2:
        phonebook1.remove_contact()

    if choice == 3:
        phonebook1.look_contact()

    if choice == 4:
        phonebook1.update_contact()

    if choice == 5:
        phonebook1.display_contact()

    if choice == 6:
        phonebook1.delete_contacts()

    if choice == 7:
        phonebook1.exit_phonebook()


for i in range(1, 10000000):
    choose()





