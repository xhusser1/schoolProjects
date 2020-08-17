DISK = "X"
EMPTY = ""


def move_disk(source, target, towers):
    ''' function move_disk
        parameters: name of source tower, name of target tower (strings), and
                    the towers themselves, a dictionary with key (string)
                    and value (list of strings to represent disks)
        returns: nothing

        does: modifies the given towers so that the source tower removes
              one disk (replaces with empty string), and adds one disk
              to the target tower. Calls print towers at the end so we
              illustrate the result of doing the move.

              About the input: towers is a dictionary. key = name of tower,
              and value = list of disk strings. For example, we might have
              tower["A"] is a list with ["", "X", "XXX"], to represent
              that the tower with name A has two disks and one blank space.
              Disks are represented by a number of Xs corresponding to their
              size.
    '''
    print("Moving disk from", source, "to", target)

    # attempt to retrieve top disk from source
    disk_num = EMPTY
    for i in range(len(towers[source])):
        if towers[source][i] != EMPTY:
            disk_num = towers[source][i]
            towers[source][i] = EMPTY
            break

    # report if no disk to retrieve
    if disk_num == EMPTY:
        print("Error: can't move disk from empty tower")

    # find top of target tower
    not_empty_index = 0
    for i in range(len(towers[target])):
        if towers[target][i] != EMPTY:
            not_empty_index = i
            break

    # put moved disk on top
    towers[target][not_empty_index - 1] = disk_num

    print_towers(towers)


def print_towers(towers):
    ''' function print_towers
        parameters: towers, a dictionary with key (string for tower name) and
                    value (list of strings to represent disks)
        returns: nothing

        does: prints the current state of the towers. Names of towers are
              printed across the top, and then the disks are printed to the
              correct overall height.
    '''
    # get length of towers
    num_disks = len(next(iter(towers.values())))

    # print first line with tower names formatted for disk size
    for tower in towers:
        print("{:^{width}}".format(tower, width = num_disks * 2),
              "\t", end = "")
    print("")

    # print towers line by line starting at the top, formatted for disk size
    for i in range(num_disks):
        for tower in towers:
            print("{:^{width}}".format(towers[tower][i], width = num_disks * 2),
                  "\t", end = "")
        print("")
    print("\n")


def initialize_towers(num_disks, source, target, middle):
    ''' function initialize_towers
        parameters: initial height, plus names of source, target, middle towers
                    (all strings)
        returns: towers, a dictionary with key = name of tower and
                 value = a list of disks (all strings)
    '''
    # make empty dictionary with keys for each tower
    towers = {source: [], target: [], middle: []}

    # fill values in dictionary with strings representing disks
    for i in range(num_disks):
        towers[source].append(DISK * (i * 2 + 1))
        towers[target].append("")
        towers[middle].append("")

    print_towers(towers)
    return towers
