from collections import deque
def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)
    bridge = deque([0] * bridge_length)
    answer = 0
    bw = 0
    
    while bridge:
        answer += 1
        temp = bridge.popleft()
        if temp > 0:
            bw -= temp
        if truck_weights:
            if bw + truck_weights[0] <= weight:
                bw += truck_weights[0]
                bridge.append(truck_weights.popleft())
            else:
                bridge.append(0)
    return answer
            
        