class CPU:
    def freeze(self):
        pass

    def jump(self, position):
        pass

    def execute(self):
        pass


class Memory:
    def load(self, position, data):
        pass


class HardDrive:
    def read(self, lba, size):
        pass


class ComputerFacade:
    def __init__(self):
        self.cpu = CPU()
        self.memory = Memory()
        self.hard_drive = HardDrive()

    def start_computer(self):
        self.cpu.freeze()
        self.memory.load("BOOT_ADDRESS", self.hard_drive.read(
            "BOOT_SECTOR", "SECTOR_SIZE"))
        self.cpu.jump("BOOT_ADDRESS")
        self.cpu.execute()
