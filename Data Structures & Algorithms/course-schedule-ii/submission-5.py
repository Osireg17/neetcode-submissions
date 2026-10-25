class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # we first create a map the size of number of numCourses
        # we loop through prerequesties with the variables pre, curr(current course)
        # we add both to the map
        adjacency_map = {course: [] for course in range(numCourses)}
        for curr, pre in prerequisites:
            adjacency_map[pre].append(curr)

        output = []
        visited, path = set(), set()

        def dfs(course):

            # Need to do some checks here for whether the cycle is detected
            if course in path:
                return False

            if course in visited:
                return True

            # we add to the path first after base check
            path.add(course)
            
            # for loop for a recursive dfs to go to it's neighbour
            for neighbour in adjacency_map[course]:
                if dfs(neighbour) == False:
                    return False
            
            # we need to add/remove values to all three output, visited, path
            path.remove(course)
            visited.add(course)
            output.append(course)
            return True

        # need to call the dfs and pass something into it, question is what?
        for course in range(numCourses):
            if dfs(course) == False:
                return []
        return output[::-1]