#include <random>
#include <sstream>

class IdGenerator {
    public:
    static std::string generateUniqueUserID(){
        //simple ID generation logic
        return "UID" + std::to_string(rand());
    }
};

