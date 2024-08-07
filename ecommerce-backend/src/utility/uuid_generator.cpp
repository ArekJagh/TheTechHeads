#include "uuid_generator.h"

#include <sstream>

std::string UUIDGenerator::generateUUID(){
    boost::uuids::uuid uuid = boost::uuids::random_generator()();
    return to_string(uuid);
}