import heapq
class Solution:
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if len(intervals) == 0:
            return 0
        
        intervals = sorted(intervals)
        res_heap = []
        heapq.heappush(res_heap, intervals[0][1])
        for i in range(1, len(intervals)):
            if intervals[i][0] < res_heap[0]:
                heapq.heappush(res_heap, intervals[i][1])
            else:
                heapq.heappop(res_heap)
                heapq.heappush(res_heap, intervals[i][1])#update the end time of the smallest end time
        return len(res_heap)